(ns view.views
  (:use stencil.core
  	    clavatar.core
  	    orm))

(defn index-page []
	(let [cv_data read-json]
   (render-file
             "templates/index"
             {:name (get-in cv_data [:name])
              :email (get-in cv_data [:email])
              :phone (get-in cv_data [:phone])
              :pic (gravatar (get-in cv_data [:email]) :default :mm :size 200 :https false)
              :skills (get-in cv_data [:skills])
              :summary (get-in cv_data [:summary])
              :employment (get-in cv_data [:employment_history])
             })))
