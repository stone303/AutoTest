package operator.basecom;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class JsonBase {

    public static String GetJsonValue(JSONObject jsonObject, String str)
    {
        return jsonObject.getString(str);
    }


    public static String GetJsonValue(JSONObject jsonObject,String key, String paramsnama)
    {
        return jsonObject.getJSONObject(key).getString(paramsnama);
    }

    public static String GetJsonValue(JSONObject responsestr,String testarray,int arraynumber,String pmsname)
    {
        if(responsestr.isEmpty()||testarray.isEmpty()||pmsname.isEmpty())
        {
            return null;
        }
        else {
            JSONArray array = (JSONArray) responsestr.get(testarray);

            String text = (String) array.getJSONObject(arraynumber).get(pmsname);
            //System.out.println(text);

            return text;
        }

    }




}
