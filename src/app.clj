(ns app
  (:use [org.httpkit.server :only [run-server]]
        [compojure.handler :only [site]]
        [compojure.core :only [defroutes GET POST]]
        view.views)
  (:require [compojure.route :as route]
            [ring.middleware.reload :as reload]))

(defroutes app-routes
  (GET "/" [] (index-page))
  (GET "/foo" [] "<h1>foo</h1>")
  (route/resources "/")
  (route/not-found "Not Found"))

(defn in-dev? [& args] true) ;; TODO read a config variable from command line, env, or file?

(defn -main [& args] 
  (let [handler (if (in-dev? args)
                 (reload/wrap-reload (site #'app-routes)) ;; only reload when dev
                  (site app-routes))]
    (run-server handler {:port 8080})))

;; edn