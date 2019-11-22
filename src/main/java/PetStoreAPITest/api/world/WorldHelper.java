package PetStoreAPITest.api.world;


import PetStoreAPITest.api.httpsVerbs.BaseVerb;
import PetStoreAPITest.api.httpsVerbs.GetVerb;
import PetStoreAPITest.api.httpsVerbs.PostVerb;

public class WorldHelper {


    private static BaseVerb baseVerb;
    private static GetVerb getVerb;
    private static PostVerb postVerb;


    public BaseVerb baseVerb() {
        if(baseVerb != null) return baseVerb;
        baseVerb = new BaseVerb();
        return baseVerb;
    }


    public GetVerb getVerb() {
        if(getVerb != null) return getVerb;
        getVerb = new GetVerb();
        return getVerb;
    }

    public PostVerb postVerb() {
        if(postVerb != null) return postVerb;
        postVerb = new PostVerb();
        return postVerb;
    }


}
