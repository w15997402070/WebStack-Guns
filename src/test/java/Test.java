import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jsnjfz.manage.modular.system.model.WxMsg;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author WangZhengPeng
 * @date 2024/2/9 18:38
 */
@Slf4j

public class Test {
    String postData = "<xml>\n" +
            " <ToUserName><![CDATA[公众号]]></ToUserName>\n" +
            " <FromUserName><![CDATA[粉丝号]]></FromUserName>\n" +
            " <CreateTime>1460537339</CreateTime>\n" +
            " <MsgType><![CDATA[text]]></MsgType>\n" +
            " <Content><![CDATA[欢迎开启公众号开发者模式]]></Content>\n" +
            " <MsgId>6272960105994287618</MsgId>\n" +
            "</xml>";
    @org.junit.Test
    public void test1(){


        Document document = XmlUtil.parseXml(postData);
        Node firstChild = document.getFirstChild();
        NodeList content = document.getElementsByTagName("Content");
        Node item = content.item(0);
        String textContent = item.getTextContent();
        log.info("textContent: {}", textContent);
        WxMsg wxMsg = XmlUtil.xmlToBean(firstChild, WxMsg.class);
        log.info(JSONUtil.toJsonStr(wxMsg));
        String s = JSONUtil.toJsonStr(wxMsg);
        JSONObject jsonObject = JSONUtil.parseObj(s);
        Document xml = XmlUtil.mapToXml(jsonObject, "xml");
        org.w3c.dom.Element documentElement = xml.getDocumentElement();
        String s1 = XmlUtil.toStr(xml.getFirstChild());
        log.info("s1:{}", s1);
        Document document1 = XmlUtil.beanToXml(wxMsg);
    }

    @org.junit.Test
    public void test3(){
        SAXReader reader = new SAXReader();
        try {
            org.dom4j.Document document = DocumentHelper.parseText(postData);
            Element rootElement = document.getRootElement();
            org.dom4j.Node content1 = rootElement.selectSingleNode("Content");
            String text = content1.getText();
            log.info("text: {}", text);
            log.info("text: {}", rootElement.asXML());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
