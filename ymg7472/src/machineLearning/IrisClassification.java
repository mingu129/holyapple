package machineLearning; 


import org.apache.log4j.BasicConfigurator;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.common.io.ClassPathResource;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerStandardize;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.deepleaning4j 
 * IrisClassification.java
 *
 * ���� :
 * 	Iris �� �з� : https://deeplearning4j.konduit.ai/
 * 	��/����� �ν� �з� Keras ��� CNN �˰���: https://chealin93.tistory.com/69
 * 
 * 	�ڹ� ������ ���� : w
 * </pre>
 * 
 * @since : 2020. 11. 8.
 * @author : tobby48
 * @version : v1.0
 */
public class IrisClassification {

    private static final int FEATURES_COUNT = 4;
    private static final int CLASSES_COUNT = 3;

    public static void main(String[] args) {

        BasicConfigurator.configure();
        loadData();

    }

    private static void loadData() {
        try{
        	//	csv ������ Read
        	RecordReader recordReader = new CSVRecordReader(0,',');
            recordReader.initialize(new FileSplit(
            		//	class�н��� �߰� �Ǿ��ִ� ��ηκ��� Read (Build Path�� �߰��Ǿ� �ִ� ���)
                    new ClassPathResource("ml/iris.csv").getFile()
            ));

            //	�����͸� �з��ϴ� ������ �Ǵ� Feature ����
            //	�����͸� �з� ���� (�����Ϳ� �з��� ���� �󺧸��� �Ǿ� �־�� ��)
            //	Ư�� �õ�(��¥ ������ ���� ������ ������ ���� ����) �� ���� �����͸� ����
            DataSetIterator iterator = new RecordReaderDataSetIterator(recordReader, 150, FEATURES_COUNT, CLASSES_COUNT);
            DataSet allData = iterator.next();
            allData.shuffle(123);

            //	����ȭ(Normalization) : �ӽŷ��׿��� Input�Ǵ� �����ʹ� ���� ����ȭ�� ��ġ�� �ȴ�.
            //	���Ժ���
            //	ex. �츮���� ���� ��� �ܸ� ����(���� �׷� ���� �����Ѵٸ�)�� 50���̶��, �翬�� 50�� �α��� ����� ���� ���� ���̴�. 80�� �̻��� ����� �׸�ŭ ���� ���̴�. 
            //	�׷����� �ұ��ϰ� ��Ե� 80�� �̻��� ���ڿ� ��ȥ�Ϸ��� �Ѵٸ� �׸�ŭ ��ȥȮ���� �������� ���̴�.
            //	�� ���
            //	��� ����: 
            //		1. ǥ��ȭ �� �Է��� ���� Gradient Descent �� Bayesian estimation�� ���� ���ϰ� ����
            //		2. 0~1�� ǥ��ȭ
            //	Gradient Descent : ���� ��¥�⸦ ã�� ���� ������ ���� ���ĸ� ������ �������� ���� �������� �� ��. �̺��� ���� ���
            //	Bayesian estimation : �ڽ��� ������ �ó������� ������ ���� ������ ���� Update�ǰ� ����Ǿ����� �˰���.
            DataNormalization normalizer = new NormalizerStandardize();
            normalizer.fit(allData);
            normalizer.transform(allData);

            //	������ ���� : ������ 65%(0.65)�� �׽�Ʈ �� ������ 35%(0.35)
            SplitTestAndTrain testAndTrain = allData.splitTestAndTrain(0.65);
            DataSet trainingData = testAndTrain.getTrain();
            DataSet testingData = testAndTrain.getTest();

            irisNNetwork(trainingData, testingData);

        } catch (Exception e) {
            Thread.dumpStack();
            new Exception("Stack trace").printStackTrace();
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    private static void irisNNetwork(DataSet trainingData, DataSet testData) {

    	//	���� �Ű��
    	//	https://miro.medium.com/max/625/1*VBRB-_ukJfaZ3HHN1CgJCg.png
    	//	https://youtu.be/bfmFfD2RIcg
        MultiLayerConfiguration configuration = new NeuralNetConfiguration.Builder()
                .activation(Activation.TANH)
                .weightInit(WeightInit.XAVIER)
                .updater(new Nesterovs(0.1, 0.9))
                .l2(0.0001)
                .list()
                .layer(0, new DenseLayer.Builder().nIn(FEATURES_COUNT).nOut(3).build())
                .layer(1, new DenseLayer.Builder().nIn(3).nOut(3).build())
                .layer(2, new OutputLayer.Builder(
                        LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD).activation(Activation.SOFTMAX)
                        .nIn(3).nOut(CLASSES_COUNT).build())
//                .backprop(true).pretrain(false)
                .build();

        //	�Ű�� �� ���� (�Ʒ� �������� ����)
        MultiLayerNetwork model = new MultiLayerNetwork(configuration);
        model.init();
        model.fit(trainingData);

        //	�Ʒõ� ���� �׽�Ʈ �����͸� ���� ��
        INDArray output = model.output(testData.getFeatures());
        Evaluation eval = new Evaluation(3);
        eval.eval(testData.getLabels(), output);
        System.out.println(eval.stats());

//        Accuracy:        ��Ȯ��
//        Precision:       ���е�
//        Recall:          ������
//        F1 Score:        �׽�Ʈ�� ���е��� ���������� ���Ǵ� ��Ȯ���� ��Ÿ���� ô��
    }
}