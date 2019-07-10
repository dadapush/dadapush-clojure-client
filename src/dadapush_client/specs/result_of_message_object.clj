(ns dadapush-client.specs.result-of-message-object
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [dadapush-client.specs.message-object :refer :all]
            )
  (:import (java.io File)))


(def result-of-message-object-data
  {
   (ds/req :code) int?
   (ds/opt :data) message-object-spec
   (ds/req :errmsg) string?
   })

(def result-of-message-object-spec
  (ds/spec
    {:name ::result-of-message-object
     :spec result-of-message-object-data}))
