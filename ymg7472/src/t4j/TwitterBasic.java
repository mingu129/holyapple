package t4j;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterBasic {

    private Twitter getInstance() {
        //  twitter ������ �ִٸ� ���� ���� ���
        //  �׷��� ���� �ÿ��� �����ͺ��̽��� �ִ� ���� ���
        String consumerKey = "M3ioqfTgFkX2x04cYj8zoxoqB";
        String consumerSecret = "W52Zj3NL4CCwN1ROFsJY2M6qP6AZtNtWu2Ppkvf21x7PkFnEcz";
        String acessToken = "728767904-rvWxQuaQ7kIpOibulxvoHipDT8pWuEoukp4GaFYu";
        String acessTokenSecret = "DrIV41WcnXKCTW1rDUAzmcD4alzq3cHYW90pfrOvvhuvL";

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(acessToken)
                .setOAuthAccessTokenSecret(acessTokenSecret);
        TwitterFactory tf = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }
    
    public List<Status> getTwitterContents(Query query, int totalCount){
        List<Status> tweetList = null;
        if(totalCount < 100){
            query.setCount(totalCount);
            tweetList = this.getTweetBlock(query);
        }else{
            //  Quiz.
            //  ���� ������ ��. Ʈ���ʹ� �ѹ��� 100���� ����
            //  Status Ŭ������ ��ü �� id���� ���� ����
//          query.setCount(100);    //Ʈ���� API ���� �ѹ��� ������ �� �ִ� ���� 100��
//          long lowestStatusId = Long.MAX_VALUE;
//          List<Status> statuses = this.getTweetBlock(query);
//          for (Status status : statuses) {
//              lowestStatusId = Math.min(status.getId(), lowestStatusId);
//              result.add(status);
//          }
//          query.setMaxId(lowestStatusId - 1);
        }
        return tweetList;
    }
    
    private List<Status> getTweetBlock(Query query){
        if(query.getMaxId() != 0){
            query.setMaxId(query.getMaxId());
        }
        List<Status> result = null;
        QueryResult queryResult = null;
        try{
            Twitter twitter = getInstance();
            queryResult = twitter.search(query);
        }catch (TwitterException e){
            e.printStackTrace();
        }

        if(queryResult != null){
            result = new ArrayList<>();
            for (Status status : queryResult.getTweets()) {
                result.add(status);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TwitterBasic twitter = new TwitterBasic();
        Query query = new Query();
        query.setLang("ko");
        query.setQuery("�����");
        query.setSince("2019-09-28");
        
        List<Status> result = twitter.getTwitterContents(query, 90);
        for(Status s : result) {
            System.out.println(s);
            //  VO Ŭ������ ��ü���·� ��ȯ�Ͽ� �پ��ϰ� Ȱ��
        }
        
    }
}