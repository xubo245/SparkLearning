# SparkBigData



Data:
1.Kmeans data:
hadoop@Master:~/cloud/spark-1.5.2/data/mllib$ ll
total 816
drwxr-xr-x 5 hadoop hadoop   4096 11月  4 02:05 ./
drwxr-xr-x 3 hadoop hadoop   4096 11月  4 02:05 ../
drwxr-xr-x 2 hadoop hadoop   4096 11月  4 02:05 als/
-rw-r--r-- 1 hadoop hadoop  63973 11月  4 02:05 gmm_data.txt
-rw-r--r-- 1 hadoop hadoop     72 11月  4 02:05 kmeans_data.txt
drwxr-xr-x 2 hadoop hadoop   4096 11月  4 02:05 lr-data/
-rw-r--r-- 1 hadoop hadoop 197105 11月  4 02:05 lr_data.txt
-rw-r--r-- 1 hadoop hadoop     24 11月  4 02:05 pagerank_data.txt
-rw-r--r-- 1 hadoop hadoop    164 11月  4 02:05 pic_data.txt
drwxr-xr-x 2 hadoop hadoop   4096 11月  4 02:05 ridge-data/
-rw-r--r-- 1 hadoop hadoop 104736 11月  4 02:05 sample_binary_classification_data.txt
-rw-r--r-- 1 hadoop hadoop     68 11月  4 02:05 sample_fpgrowth.txt
-rw-r--r-- 1 hadoop hadoop   1598 11月  4 02:05 sample_isotonic_regression_data.txt
-rw-r--r-- 1 hadoop hadoop    264 11月  4 02:05 sample_lda_data.txt
-rw-r--r-- 1 hadoop hadoop 104736 11月  4 02:05 sample_libsvm_data.txt
-rwxr-xr-x 1 hadoop hadoop 119069 11月  4 02:05 sample_linear_regression_data.txt*
-rw-r--r-- 1 hadoop hadoop  14351 11月  4 02:05 sample_movielens_data.txt
-rw-r--r-- 1 hadoop hadoop   6953 11月  4 02:05 sample_multiclass_classification_data.txt
-rw-r--r-- 1 hadoop hadoop     95 11月  4 02:05 sample_naive_bayes_data.txt
-rw-r--r-- 1 hadoop hadoop  39474 11月  4 02:05 sample_svm_data.txt
-rw-r--r-- 1 hadoop hadoop 115476 11月  4 02:05 sample_tree_data.csv
in https://github.com/apache/spark

2.SparkSQL data from spark:
hadoop@Master:~/cloud/spark-1.5.2/examples/src/main/resources$ ll
total 40
drwxr-xr-x 2 hadoop hadoop 4096 11月  4 02:05 ./
drwxr-xr-x 7 hadoop hadoop 4096 11月  4 02:05 ../
-rw-r--r-- 1 hadoop hadoop  240 11月  4 02:05 full_user.avsc
-rw-r--r-- 1 hadoop hadoop 5812 11月  4 02:05 kv1.txt
-rw-r--r-- 1 hadoop hadoop   73 11月  4 02:05 people.json
-rw-r--r-- 1 hadoop hadoop   32 11月  4 02:05 people.txt
-rw-r--r-- 1 hadoop hadoop  185 11月  4 02:05 user.avsc
-rw-r--r-- 1 hadoop hadoop  334 11月  4 02:05 users.avro
-rw-r--r-- 1 hadoop hadoop  615 11月  4 02:05 users.parquet
in https://github.com/apache/spark

3.SparkSQL from databricks:
you can down form:
https://github.com/databricks/spark-training/tree/master/data/wiki_parquet
