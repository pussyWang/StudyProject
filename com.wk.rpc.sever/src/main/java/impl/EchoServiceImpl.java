package impl;

import annotation.EchoService;

/**
 * PackageName impl
 * Created by wangkang on 2017/10/18.
 */
public class EchoServiceImpl implements EchoService {
    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok." : "I am ok";
    }
}
