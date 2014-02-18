(ns cloju-cv.twitter
   (:use
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.restful])
  (:import
   (twitter.callbacks.protocols SyncSingleCallback))
  (:require [cheshire.core :refer :all]))

(def my-creds (let [{:keys [api-key api-secret user-access-token user-access-token-secret]} (parse-string
               (slurp "twitter_cred.json") true)] 
				(make-oauth-creds api-key api-secret user-access-token user-access-token-secret)))

(defn get-latest-tweets [count]
(statuses-user-timeline :callbacks (SyncSingleCallback. response-return-body 
                                                  response-throw-error
                                                  exception-rethrow) :oauth-creds my-creds :params 
												  {:target-screen-name "n1koo" :count count}))

(defn get-latest-tweet-msgs [count]
(parse-string (generate-string (for [x (map :text (get-latest-tweets count))] {:text x}))true))