(ns dadapush-client.specs.result-of-message-push-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [dadapush-client.specs.message-push-response :refer :all]
            )
  (:import (java.io File)))


(def result-of-message-push-response-data
  {
   (ds/req :code) int?
   (ds/opt :data) message-push-response-spec
   (ds/req :errmsg) string?
   })

(def result-of-message-push-response-spec
  (ds/spec
    {:name ::result-of-message-push-response
     :spec result-of-message-push-response-data}))
