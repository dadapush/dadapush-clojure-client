(ns dadapush-client.api.da-da-push-message
  (:require [dadapush-client.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [dadapush-client.specs.result :refer :all]
            [dadapush-client.specs.result-of-message-object :refer :all]
            [dadapush-client.specs.result-of-page-response-of-message-object :refer :all]
            [dadapush-client.specs.message-object :refer :all]
            [dadapush-client.specs.result-of-message-push-response :refer :all]
            [dadapush-client.specs.message-push-response :refer :all]
            [dadapush-client.specs.message-push-request :refer :all]
            [dadapush-client.specs.action :refer :all]
            [dadapush-client.specs.page-response-of-message-object :refer :all]
            )
  (:import (java.io File)))


(defn-spec create-message-with-http-info any?
  "push Message to a Channel
  <h2>Rate Limit:</h2><ul><li>1 request per 1s</li><li>30 request per 1m</li><li>500 request per 1h</li></ul><h2>Result code/errmsg List:</h2><ul><li>0: ok</li><li>1: server error</li><li>101: channel is exists</li><li>102: channel is not exists</li><li>103: channel token error</li><li>104: channel is not exists</li><li>105: message is not exists</li><li>204: bad request</li><li>205: permission deny</li><li>206: too many request, please after 5 minutes to try!</li><li>301: duplicate username/email</li><li>302: user is not exists</li><li>303: user password is error</li><li>304: client push token is error</li><li>305: user is disabled</li><li>306: your subscription is expired</li><li>307: user not subscribe channel</li></ul>"
  ([body message-push-request, ] (create-message-with-http-info body nil))
  ([body message-push-request, {:keys [x-channel-token]} (s/map-of keyword? any?)]
   (check-required-params body)
   (call-api "/api/v1/message" :post
             {:path-params   {}
              :header-params {"x-channel-token" x-channel-token }
              :query-params  {}
              :form-params   {}
              :body-param    body
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec create-message result-of-message-push-response-spec
  "push Message to a Channel
  <h2>Rate Limit:</h2><ul><li>1 request per 1s</li><li>30 request per 1m</li><li>500 request per 1h</li></ul><h2>Result code/errmsg List:</h2><ul><li>0: ok</li><li>1: server error</li><li>101: channel is exists</li><li>102: channel is not exists</li><li>103: channel token error</li><li>104: channel is not exists</li><li>105: message is not exists</li><li>204: bad request</li><li>205: permission deny</li><li>206: too many request, please after 5 minutes to try!</li><li>301: duplicate username/email</li><li>302: user is not exists</li><li>303: user password is error</li><li>304: client push token is error</li><li>305: user is disabled</li><li>306: your subscription is expired</li><li>307: user not subscribe channel</li></ul>"
  ([body message-push-request, ] (create-message body nil))
  ([body message-push-request, optional-params any?]
   (let [res (:data (create-message-with-http-info body optional-params))]
     (if (:decode-models *api-context*)
        (st/decode result-of-message-push-response-spec res st/string-transformer)
        res))))


(defn-spec delete-message-with-http-info any?
  "delete a Channel Message
  <h2>Rate Limit:</h2><ul><li>10 request per 1s</li><li>100 request per 1m</li><li>1000 request per 1h</li></ul><h2>Result code/errmsg List:</h2><ul><li>0: ok</li><li>1: server error</li><li>101: channel is exists</li><li>102: channel is not exists</li><li>103: channel token error</li><li>104: channel is not exists</li><li>105: message is not exists</li><li>204: bad request</li><li>205: permission deny</li><li>206: too many request, please after 5 minutes to try!</li><li>301: duplicate username/email</li><li>302: user is not exists</li><li>303: user password is error</li><li>304: client push token is error</li><li>305: user is disabled</li><li>306: your subscription is expired</li><li>307: user not subscribe channel</li></ul>"
  ([messageId int?, ] (delete-message-with-http-info messageId nil))
  ([messageId int?, {:keys [x-channel-token]} (s/map-of keyword? any?)]
   (check-required-params messageId)
   (call-api "/api/v1/message/{messageId}" :delete
             {:path-params   {"messageId" messageId }
              :header-params {"x-channel-token" x-channel-token }
              :query-params  {}
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec delete-message result-spec
  "delete a Channel Message
  <h2>Rate Limit:</h2><ul><li>10 request per 1s</li><li>100 request per 1m</li><li>1000 request per 1h</li></ul><h2>Result code/errmsg List:</h2><ul><li>0: ok</li><li>1: server error</li><li>101: channel is exists</li><li>102: channel is not exists</li><li>103: channel token error</li><li>104: channel is not exists</li><li>105: message is not exists</li><li>204: bad request</li><li>205: permission deny</li><li>206: too many request, please after 5 minutes to try!</li><li>301: duplicate username/email</li><li>302: user is not exists</li><li>303: user password is error</li><li>304: client push token is error</li><li>305: user is disabled</li><li>306: your subscription is expired</li><li>307: user not subscribe channel</li></ul>"
  ([messageId int?, ] (delete-message messageId nil))
  ([messageId int?, optional-params any?]
   (let [res (:data (delete-message-with-http-info messageId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode result-spec res st/string-transformer)
        res))))


(defn-spec get-message-with-http-info any?
  "get a Channel Message
  <h2>Rate Limit:</h2><ul><li>10 request per 1s</li><li>100 request per 1m</li><li>1000 request per 1h</li></ul><h2>Result code/errmsg List:</h2><ul><li>0: ok</li><li>1: server error</li><li>101: channel is exists</li><li>102: channel is not exists</li><li>103: channel token error</li><li>104: channel is not exists</li><li>105: message is not exists</li><li>204: bad request</li><li>205: permission deny</li><li>206: too many request, please after 5 minutes to try!</li><li>301: duplicate username/email</li><li>302: user is not exists</li><li>303: user password is error</li><li>304: client push token is error</li><li>305: user is disabled</li><li>306: your subscription is expired</li><li>307: user not subscribe channel</li></ul>"
  ([messageId int?, ] (get-message-with-http-info messageId nil))
  ([messageId int?, {:keys [x-channel-token]} (s/map-of keyword? any?)]
   (check-required-params messageId)
   (call-api "/api/v1/message/{messageId}" :get
             {:path-params   {"messageId" messageId }
              :header-params {"x-channel-token" x-channel-token }
              :query-params  {}
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-message result-of-message-object-spec
  "get a Channel Message
  <h2>Rate Limit:</h2><ul><li>10 request per 1s</li><li>100 request per 1m</li><li>1000 request per 1h</li></ul><h2>Result code/errmsg List:</h2><ul><li>0: ok</li><li>1: server error</li><li>101: channel is exists</li><li>102: channel is not exists</li><li>103: channel token error</li><li>104: channel is not exists</li><li>105: message is not exists</li><li>204: bad request</li><li>205: permission deny</li><li>206: too many request, please after 5 minutes to try!</li><li>301: duplicate username/email</li><li>302: user is not exists</li><li>303: user password is error</li><li>304: client push token is error</li><li>305: user is disabled</li><li>306: your subscription is expired</li><li>307: user not subscribe channel</li></ul>"
  ([messageId int?, ] (get-message messageId nil))
  ([messageId int?, optional-params any?]
   (let [res (:data (get-message-with-http-info messageId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode result-of-message-object-spec res st/string-transformer)
        res))))


(defn-spec get-messages-with-http-info any?
  "get Message List
  <h2>Rate Limit:</h2><ul><li>1 request per 1s</li><li>45 request per 1m</li></ul><h2>Result code/errmsg List:</h2><ul><li>0: ok</li><li>1: server error</li><li>101: channel is exists</li><li>102: channel is not exists</li><li>103: channel token error</li><li>104: channel is not exists</li><li>105: message is not exists</li><li>204: bad request</li><li>205: permission deny</li><li>206: too many request, please after 5 minutes to try!</li><li>301: duplicate username/email</li><li>302: user is not exists</li><li>303: user password is error</li><li>304: client push token is error</li><li>305: user is disabled</li><li>306: your subscription is expired</li><li>307: user not subscribe channel</li></ul>"
  ([page int?, pageSize int?, ] (get-messages-with-http-info page pageSize nil))
  ([page int?, pageSize int?, {:keys [x-channel-token]} (s/map-of keyword? any?)]
   (check-required-params page pageSize)
   (call-api "/api/v1/messages" :get
             {:path-params   {}
              :header-params {"x-channel-token" x-channel-token }
              :query-params  {"page" page "pageSize" pageSize }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec get-messages result-of-page-response-of-message-object-spec
  "get Message List
  <h2>Rate Limit:</h2><ul><li>1 request per 1s</li><li>45 request per 1m</li></ul><h2>Result code/errmsg List:</h2><ul><li>0: ok</li><li>1: server error</li><li>101: channel is exists</li><li>102: channel is not exists</li><li>103: channel token error</li><li>104: channel is not exists</li><li>105: message is not exists</li><li>204: bad request</li><li>205: permission deny</li><li>206: too many request, please after 5 minutes to try!</li><li>301: duplicate username/email</li><li>302: user is not exists</li><li>303: user password is error</li><li>304: client push token is error</li><li>305: user is disabled</li><li>306: your subscription is expired</li><li>307: user not subscribe channel</li></ul>"
  ([page int?, pageSize int?, ] (get-messages page pageSize nil))
  ([page int?, pageSize int?, optional-params any?]
   (let [res (:data (get-messages-with-http-info page pageSize optional-params))]
     (if (:decode-models *api-context*)
        (st/decode result-of-page-response-of-message-object-spec res st/string-transformer)
        res))))


