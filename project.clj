(defproject cloodle "0.1.0-SNAPSHOT"
  :description "Awesome cloodle application by Pitäjänmäki hackers!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [om "0.7.3"]
                 [prismatic/om-tools "0.3.2" :exclusions [org.clojure/clojure]]
                 [cljs-http "0.1.16"]
                 [jayq "2.5.2"]
                 [compojure "1.1.8"]
                 [ring "1.2.1"]
                 [com.novemberain/monger "2.0.0"]
                 [ring/ring-json "0.3.1"]
                 [crypto-random "1.2.0"]
                 [com.novemberain/validateur "2.3.1"]
                 [cheshire "5.3.1"]

                 ]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]}
             :test-test-paths {:test-paths ["test"]}
             :plugins [[lein-midje "3.1.3"]]}
  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.10"]]
  :hooks [leiningen.cljsbuild]
  :source-paths ["src/clj"]
  :cljsbuild {
    :builds {
      :main {
        :source-paths ["src/cljs"]
        :compiler {:output-to "resources/public/js/cloodle.js"
                   :output-dir "resources/public/js"
                   :optimizations :none
                   :pretty-print true
                   :source-map "resources/public/js/cloodle.js.map"
                   :externs ["resources/public/ext-js/jquery.nouislider.all.js"]
                   }
        :jar true}}}
  :main cloodle.server
  :ring {:handler cloodle.server/app
         :init cloodle.mongodao/init})
