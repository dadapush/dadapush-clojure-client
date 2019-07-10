(ns dadapush-client.specs.message-push-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def message-push-response-data
  {
   (ds/req :messageId) int?
   })

(def message-push-response-spec
  (ds/spec
    {:name ::message-push-response
     :spec message-push-response-data}))
