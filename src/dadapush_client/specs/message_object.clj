(ns dadapush-client.specs.message-object
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [dadapush-client.specs.action :refer :all]
            )
  (:import (java.io File)))


(def message-object-data
  {
   (ds/opt :actions) (s/coll-of action-spec)
   (ds/req :channelName) string?
   (ds/req :content) string?
   (ds/req :createdAt) string?
   (ds/req :id) int?
   (ds/req :title) string?
   })

(def message-object-spec
  (ds/spec
    {:name ::message-object
     :spec message-object-data}))
