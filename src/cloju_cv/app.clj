(ns cloju-cv.app
  (:use [org.httpkit.server :only [run-server]]
        [compojure.handler :only [site]]
        [compojure.core :only [defroutes GET POST]]
        cloju-cv.view.views
        cloju-cv.properties )
  (:require [compojure.route :as route]
            [ring.middleware.reload :as reload])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] (index-page))
  (GET "/foo" [] "<h1>foo</h1>")
  (route/resources "/")
  (route/not-found "Not Found"))



(defn in-dev? [& args] true) ;; TODO read a config variable from command line, env, or file?

(defn -main [& args] 
  (let [handler (if (in-dev? args)
               (do (stencil.loader/set-cache (clojure.core.cache/ttl-cache-factory {} :ttl 0))
                   (reload/wrap-reload (site #'app-routes)))
                 (site app-routes))]
    (run-server handler {:port (get-in load-props [:port]) :ip (get-in load-props [:ip])})))



