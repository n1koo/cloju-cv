(ns twitter
   (:use
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.restful])
  (:import
   (twitter.callbacks.protocols SyncSingleCallback))
  (:require [cheshire.core :refer :all]))

(def my-creds (let [{:keys [api-key api-secret user-access-token user-access-token-secret]} (parse-string
               "twitter_cred.json" true)] (make-oauth-creds api-key api-secret user-access-token user-access-token-secret)))