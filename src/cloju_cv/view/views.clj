(ns cloju-cv.view.views
  (:use stencil.core
  	    clavatar.core
  	    cloju-cv.orm
        cloju-cv.twitter))

(defn index-page []
	(let [cv_data read-json]
   (render-file
             "templates/index"
             {:name (get-in cv_data [:name])
              :email (get-in cv_data [:email])
              :phone (get-in cv_data [:phone])
              :pic (gravatar (get-in cv_data [:email]) :default :mm :size 150 :https false)
              :url (get-in cv_data [:urls])
              :summary (get-in cv_data [:summary])
              :education (get-in cv_data [:education])
              :skills (get-in cv_data [:skills])
              :non_tech_skills (get-in cv_data [:non_tech_skills])
              :employment (get-in cv_data [:employment_history])
              :twitter (get-latest-tweet-msgs 5)
             })))
