(ns cloju-cv.properties
  (:require  clojure.java.io))

(def load-props
  (with-open [^java.io.Reader reader (clojure.java.io/reader "cloju-cv.properties")] 
    (let [props (java.util.Properties.)]
      (.load props reader)
      (into {} (for [[k v] props] [(keyword k) (read-string v)])))))