(defproject zippy "0.1.0-SNAPSHOT"
  :description "zip border polydata microservice"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-alpha5"]
                 [compojure "1.3.2"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-json "0.3.1"]
                 [ring/ring-defaults "0.1.4"]
                 [yesql "0.4.0"]
                 [mysql/mysql-connector-java "5.1.6"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler cljrest.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
