(ns zippy.handler
  (:require [zippy.query :as query]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.core :refer [GET POST defroutes]]
            [ring.util.response :refer [resource-response response]]
            [ring.middleware.json :as middleware]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defroutes app-routes
  (GET "/zipBorder/:id" [id]
       (response (query/get-zip-border id)))
  (GET "/zipCode/:id" [id]
       (response (query/get-zip-border-by-zip-code id)))
  (GET "/zipCode" {params :params} []
       (response (remove empty? (map query/get-zip-border-by-zip-code
                      (flatten (conj [] (params :zipCode)))))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (middleware/wrap-json-body {:keywords? true})
      (middleware/wrap-json-response)
      (wrap-defaults api-defaults)))
