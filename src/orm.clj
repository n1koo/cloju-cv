(ns orm
 (:require [cheshire.core :refer :all]))

(def read-json (parse-string (slurp "cv.json") true))