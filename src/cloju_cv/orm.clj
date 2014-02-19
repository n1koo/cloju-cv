(ns cloju-cv.orm
  (:use cloju-cv.properties)
  (:require [cheshire.core :refer :all]))

(def read-json (parse-string (slurp (get-in load-props [:cv-file])) true))