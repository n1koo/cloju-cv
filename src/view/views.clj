(ns view.views
  (:use stencil.core))

(defn index-page []
   (render-file
             "templates/index"
             {:name "Niko Kurtti"}))
