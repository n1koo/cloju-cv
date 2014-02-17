(ns twitter
   (:use
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.restful])
  (:import
   (twitter.callbacks.protocols SyncSingleCallback)))

(def my-creds (make-oauth-creds (get-in (json/read-str (slurp "twitter_cred.json")
                :key-fn keyword) 0)))