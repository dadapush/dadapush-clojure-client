(ns dadapush-client.specs.result
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [dadapush-client.specs. :refer :all]
            )
  (:import (java.io File)))


(def result-data
  {
   (ds/req :code) int?
   (ds/opt :data) any?
   (ds/req :errmsg) string?
   })

(def result-spec
  (ds/spec
    {:name ::result
     :spec result-data}))
