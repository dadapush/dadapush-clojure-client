(ns dadapush-client.specs.message-push-request
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [dadapush-client.specs.action :refer :all]
            )
  (:import (java.io File)))


(def message-push-request-data
  {
   (ds/opt :actions) (s/coll-of action-spec)
   (ds/req :content) string?
   (ds/req :needPush) boolean?
   (ds/req :title) string?
   })

(def message-push-request-spec
  (ds/spec
    {:name ::message-push-request
     :spec message-push-request-data}))
