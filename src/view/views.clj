(ns view.views
  (:use stencil.core))

(defn index-page []
   (render-file
             "hello"
             {:name "Niko"}))
