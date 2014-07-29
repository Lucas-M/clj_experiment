(ns compojure_experiment.routes.home
  (:require [compojure.core :refer :all]
            [compojure_experiment.views.layout :as layout]))

(defn home []
  (layout/common [:h1 "Hello World!"]))

(defroutes home-routes
  (GET "/" [] (home)))
