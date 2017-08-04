/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared;

import java.io.IOException;

/**
 *
 * @author miolivc
 */
public class MessageManagerTest {
    
    public void writeAndReadMessage() throws IOException {
        RepositoryLocator locator = new RepositoryLocator();
        
        locator.registryFunction("helloReq", "./");
        locator.registryMessageType("msgReq", "req.txt");
        
        locator.registryFunction("helloResp", "./");
        locator.registryMessageType("msgResp", "resp.txt");
        
        MessageManager manager = new MessageManager(locator);
        
        Message msgReq = new Message();
        msgReq.setIdentify("miolivc");
        msgReq.setSequence(0);
        msgReq.setOriginalSequence(0);
        msgReq.setTo("node2");
        msgReq.setFrom("node1");
        msgReq.setMsg("Hello World!");
        
        manager.write("helloReq", "msgReq", msgReq);
        
        Message msgResp = manager.read("helloReq", "msgResp");
        
        Assert.assertEquals(msgReq.getIdentify(), msgResp.getIdentify());
        Assert.assertEquals(msgReq.getSequence(), msgResp.getSequence());
        Assert.assertEquals(msgReq.getOriginalSequence(), msgResp.getOriginalSequence());
        Assert.assertEquals(msgReq.getTo(), msgResp.getTo());
        Assert.assertEquals(msgReq.getFrom(), msgResp.getFrom());
        Assert.assertEquals(msgReq.getMsg(), msgResp.getMsg());
        
    }
    
}
