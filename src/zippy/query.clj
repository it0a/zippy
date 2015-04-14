(ns zippy.query
  (:require [yesql.core :refer [defquery]]))

(def db-spec
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost:3306/zip_border"
   :user "root"
   :password "sriq@"})

(defquery zip-border "query/get-zip-border.sql")
(defquery zip-border-by-zip-code "query/get-zip-border-by-zip-code.sql")

(defn get-zip-border [id]
  (zip-border db-spec id))

(defn get-zip-border-by-zip-code [zipCode]
  (zip-border-by-zip-code db-spec zipCode))
