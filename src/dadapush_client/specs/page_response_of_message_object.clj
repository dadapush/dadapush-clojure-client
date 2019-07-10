(ns dadapush-client.specs.page-response-of-message-object
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [dadapush-client.specs.message-object :refer :all]
            )
  (:import (java.io File)))


(def page-response-of-message-object-data
  {
   (ds/opt :content) (s/coll-of message-object-spec)
   (ds/opt :totalElements) int?
   (ds/opt :totalPages) int?
   })

(def page-response-of-message-object-spec
  (ds/spec
    {:name ::page-response-of-message-object
     :spec page-response-of-message-object-data}))
