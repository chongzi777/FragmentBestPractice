package com.example.se7en.fragmentbestpractice;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻标题碎片
 * Created by se7en on 2016/1/27.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView newsTitleListView;  //新闻标题列表容器

    private List<News> newsList;  //新闻列表集合

    private NewsAdapter newsAdapter;  //新闻条目适配器

    private boolean isTwoPane;  //单双页标识

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        newsList = getNews();  //获取模拟的新闻信息
        newsAdapter = new NewsAdapter(context,R.layout.news_item,newsList);  //设置新闻适配器
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //查找news_content_layout，如果有，说明是双页模式，没有，则是单页模式
        if(getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane = true;
        }else{
            isTwoPane = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleListView = (ListView)view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(newsAdapter);
        newsTitleListView.setOnItemClickListener(this);
        return view;
    }

    /**
     * 模拟新闻数据
     * @return
     */
    private List<News> getNews(){
        List<News> newsList = new ArrayList<>();
        News news1 = new News("无人机航拍湖面结冰困住巨轮 如灾难大片","刚刚有提到热线，在大选前一天，陆委会主委夏立言曾经说不排除在选后就两岸局势会有一次热线沟通。请问从大选到今天，是否有启动热线？第二个问题是关于南海，除了马英九可能明天会登上太平岛之外，请教国台办对蔡英文的南海主张有什么评价？第三个问题，台湾大选后没几天，大陆央视有播出解放军在东南沿海的军事演习，在播完之后隔两天又有一位解放军少将在媒体上发表文章说，被“台独”逼到墙角就只能“武统”。您认为这样一连串带有武吓的讯息和两岸和平发展这样的一个主张是不是有点相违背？");
        newsList.add(news1);
        News news2 = new News("国台办回应“被逼到墙角就只能武统”说法","关于热线的问题，坚持“九二共识”是双方两岸事务主管部门联系沟通机制得以建立的重要基础，也是这一机制正常运作的必要条件。两岸热线用于沟通两岸关系重大、紧急事项。经双方沟通均认为有必要时使用。到目前为止，我不掌握近期有安排使用过。\n" +
                "第二个问题，中国对南海诸岛拥有无可争辩的主权。两岸同属一个中国。两岸同胞有责任共同维护国家主权和领土完整，维护中华民族的整体利益和根本利益。");
        newsList.add(news2);
        News news3 = new News("库昊这种任性超远三分为何同队友汤普森很少投？","第二个问题，中国对南海诸岛拥有无可争辩的主权。两岸同属一个中国。两岸同胞有责任共同维护国家主权和领土完整，维护中华民族的整体利益和根本利益。");
        newsList.add(news3);
        News news4 = new News("单节22分!全场爆砍44+14+5 杜兰特:我生来为此","第三个问题，国防部已经说明了相关情况。我还需要指出的是，和平发展的基础是坚持“九二共识”、反对“台独”。有了这个基础，两岸关系和平发展的局面就能够延续下去，和平发展的未来就会是光明灿烂的。如果破坏了这个基础，刚才我也讲到，两岸关系和平发展之舟就会遭遇惊涛骇浪，甚至彻底翻覆。谢谢。");
        newsList.add(news4);
        News news5 = new News("这部神片在全世界仅剩下了最后一份拷贝","同样是水花兄弟，阿汤的投射就接球就投来说跟库里是一个级别的吧，并且平时在训练中阿汤肯定会看库里练习那种任性三分，两人也可以有交流，学习，阿汤单节37分过的啊 那么问题来了，为何很少见到佛祖投这么任性的三分？和这么浪的人一个队难道自己不想浪一浪吗？ 是因为汤普森亘古不变的标准投篮姿势不能像库里那样随便扔，还是两人之间投篮天赋有差距？还是库昊自成一派，别人学不来");
        newsList.add(news5);
        News news6 = new News("这6部网络剧为什么被封杀","一个是现役超一流射手一个是历史级射手要是汤有库里的技能包联盟谁还能打");
        newsList.add(news6);
        return newsList;
    }

    /**
     * 新闻条目点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news = newsList.get(position);
        if(isTwoPane){
            //双页模式，获取新闻内容碎片，并刷新展示的内容
            NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(),news.getContent());
        }else{
            //单页模式，直接启动新闻内容activity
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
        }
    }
}
