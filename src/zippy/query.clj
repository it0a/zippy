(ns zippy.query
  (:require [yesql.core :refer [defquery]]))

(def db-spec
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost:3306/zip_border"
   :user "root"
   :password "sriq@"})

(defquery zip-border "query/invoice/get-zip-border.sql")

(defn get-zip-border [id]
  (zip-border db-spec id))
