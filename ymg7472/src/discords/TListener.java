package discords;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import schoolfood.MenuCrawl;
import java.io.IOException;
import java.util.List;
public class TListener extends ListenerAdapter{
	List<SentimentalDic> dicList;
	public TListener(List<SentimentalDic> dicList) {
		this.dicList = dicList;
	}
	@Override
	public void onMessageReceived (MessageReceivedEvent event) {
		User user = event.getAuthor();;
		CoronaCrawl k = new CoronaCrawl();
		EmbedBuilder result = new EmbedBuilder();
		MenuCrawl m = new MenuCrawl();
		TextChannel tc = event.getTextChannel(); 
		Message msg = event.getMessage();
		if(user.isBot()) return; 
		if(msg.getContentRaw().charAt(0) == '!') {
			String[] args = msg.getContentRaw().substring(1).split(" ");
			if(args.length <= 0) return;
			if(args[0].equalsIgnoreCase("�޽�")) {
				String date = "";
				date = args[1];
				if(!m.menu(date).equals(null)) {
					tc.sendMessage(m.menu(date)).queue();
				}else {
					tc.sendMessage("ã�� �� �����ϴ�.").queue();
				}
			}else if(args[0].equalsIgnoreCase("�ڷγ�")){
				tc.sendMessage(k.korona()).queue();
			}else if(args[0].equalsIgnoreCase("��ɾ�")){
				tc.sendMessage("!�޽� + ��¥ : �׳��� �޽��� ����մϴ�. ��) !�޽� 20200527" + "\n" + "!�ڷγ� : ���� �ڷγ� ��Ȳ�� ����մϴ�.").queue();
			}else if(args[0].equalsIgnoreCase("���ؽ�")){
				result.setTitle("��");
		        result.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR-Fd_f90rUmrvT_VCxDsdfQ51LtlVHyNykO-FgMjpcLv6O8u1J&usqp=CAU");
		        event.getChannel().sendMessage(result.build()).queue();
			}


		}
//		for(int i=0; i<dicList.size(); i++) {
//			if(dicList.get(i).getWord().equals(msg.getContentRaw()) || dicList.get(i).getWord_root().equals(msg.getContentRaw())) {
//				int polarity = Integer.parseInt(dicList.get(i).getPolarity());
//				if(polarity == 2) {
//					tc.sendMessage(user.getName()+"�� ����� ȯ�����̱���!").queue();
//				}else if(polarity == 1) {
//					tc.sendMessage(user.getName()+"�� ����� ���׿�").queue();
//				}else if(polarity == 0) {
//					tc.sendMessage(user.getName()+"�� ����� �׳� �׷��׿�").queue();
//				}else if(polarity == -1) {
//					tc.sendMessage(user.getName()+"�� ����� ���� ���� �ʱ���").queue();
//				}else if(polarity == -2) {
//					tc.sendMessage(user.getName()+"�� ����� �־��̳׿�").queue();
//				}
//			}
//		}
		
			
	}

}
