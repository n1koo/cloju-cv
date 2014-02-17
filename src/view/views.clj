(ns view.views
  (:use stencil.core
  	    clavatar.core
  	    orm))

(defn index-page []
	(let [cv_data read-json]
   (render-file
             "templates/index"
             {:name (get-in cv_data [:name])
              :pic (gravatar (get-in cv_data [:email]) :size 200)
             })))
