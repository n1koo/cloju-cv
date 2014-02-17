(ns view.views
  (:use stencil.core
  	    clavatar.core))

(defn index-page []
   (render-file
             "templates/index"
             {:name "Niko Kurtti", 
              :pic (gravatar "n1ko@salaliitto.com" :size 200)
             }))
