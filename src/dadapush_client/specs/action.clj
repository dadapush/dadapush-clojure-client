(ns dadapush-client.specs.action
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def action-data
  {
   (ds/req :name) string?
   (ds/req :type) string?
   (ds/req :url) string?
   })

(def action-spec
  (ds/spec
    {:name ::action
     :spec action-data}))
