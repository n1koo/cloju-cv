(ns orm
 (require [clojure.data.json :as json]))

(def read-json (json/read-str (slurp "cv.json")
                :key-fn keyword))