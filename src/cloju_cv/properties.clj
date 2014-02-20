(ns cloju-cv.properties
  (:require  clojure.java.io
    [cheshire.core :refer :all]))

(def load-props
  (with-open [^java.io.Reader reader (clojure.java.io/reader "cloju-cv.properties")] 
    (let [props (java.util.Properties.)]
      (.load props reader)
      (into {} (for [[k v] props] [(keyword k) (read-string v)])))))

(def read-twitter-settings (parse-string (slurp (get-in load-props [:twitter-file])) true))