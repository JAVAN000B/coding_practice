import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Classname URLLink
 * @Description TODO
 * @Author Minghui Sun, Fengjie Gu
 * @Version 1.0
 */
public class URLLink {
    public void getLink(String URL) throws MalformedURLException {
        try {
            //创建一个url实例
            URL url=new URL(URL);
            //通过url的openStream获取url对象所表示资源的字节输入流
            InputStream is=url.openStream();
            //将字节输入流转换为字符输入流
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            //为字符输入流添加缓冲
            BufferedReader br=new BufferedReader(isr);
            String res=null;
            String line=null;
            //读取数据
            while((line=br.readLine())!=null){
                res+=line;
            }
            br.close();
            isr.close();
            is.close();
            System.out.println(res);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
