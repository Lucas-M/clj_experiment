(defproject compojure_experiment "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [com.datomic/datomic-free "0.9.4880.2"]
                 [expectations "2.0.9"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler compojure_experiment.handler/app
         :init compojure_experiment.handler/init
         :destroy compojure_experiment.handler/destroy}
  :aot :all
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.1"]]}})
