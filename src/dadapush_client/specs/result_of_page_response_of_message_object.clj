(ns dadapush-client.specs.result-of-page-response-of-message-object
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [dadapush-client.specs.page-response-of-message-object :refer :all]
            )
  (:import (java.io File)))


(def result-of-page-response-of-message-object-data
  {
   (ds/req :code) int?
   (ds/opt :data) page-response-of-message-object-spec
   (ds/req :errmsg) string?
   })

(def result-of-page-response-of-message-object-spec
  (ds/spec
    {:name ::result-of-page-response-of-message-object
     :spec result-of-page-response-of-message-object-data}))
