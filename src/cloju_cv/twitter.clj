(ns cloju-cv.twitter
   (:use
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.restful]
   [cloju-cv.properties])
  (:import
   (twitter.callbacks.protocols SyncSingleCallback)))

(def my-creds (let [{:keys [api-key api-secret user-access-token user-access-token-secret]} read-twitter-settings] 
				(make-oauth-creds api-key api-secret user-access-token user-access-token-secret)))

(defn get-latest-tweets [count]
(statuses-user-timeline :callbacks (SyncSingleCallback. response-return-body 
                                                  response-throw-error
                                                  exception-rethrow) :oauth-creds my-creds :params 
												  {:target-screen-name (get-in my-creds [:screen-name]) :count count}))

(defn get-latest-tweet-msgs [count]
(for [tweet (get-latest-tweets count)] (select-keys tweet [:text])))
