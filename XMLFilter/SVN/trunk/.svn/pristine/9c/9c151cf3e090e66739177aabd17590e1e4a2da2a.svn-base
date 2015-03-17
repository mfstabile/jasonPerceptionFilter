/* 
 *  Copyright (C) 2008 Thomas Klapiscak (t.g.klapiscak@durham.ac.uk)
 *  
 *  This file is part of JASDL.
 *
 *  JASDL is free software: you can redistribute it and/or modify
 *  it under the terms of the Lesser GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  JASDL is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  Lesser GNU General Public License for more details.
 *
 *  You should have received a copy of the Lesser GNU General Public License
 *  along with JASDL.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package jasdl.architecture;

import jasdl.asSemantics.JASDLAgent;
import jasdl.bridge.protocol.ProtocolProcessor;
import jasdl.util.exception.JASDLException;
import jason.JasonException;
import jason.architecture.AgArch;
import jason.asSemantics.Message;
import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.mas2j.ClassParameters;
import jason.runtime.Settings;

import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public class JASDLAgArch extends AgArch {

    private ProtocolProcessor processor;

    @Override
    public void init() {
        processor = new ProtocolProcessor(getAgent().getJom(), getAgent().getDefaultMappingStrategies());
    }

    @Override
    public void checkMail() {
        super.checkMail();

        // temporary set to hold processed message clones
        Queue<Message> tempMail = new ConcurrentLinkedQueue<Message>();
        Queue<Message> mail = getTS().getC().getMailBox();

        // mustn't affect original message object, otherwise effects are global (i.e. at infrastructure level) 
        for (Message message : mail) {
            try {
                Message clone = (Message) message.clone();
                processIncomingMessage(clone);
                tempMail.add(clone);
            } catch (JASDLException e) {
                // don't fail, just print warning
                getLogger().warning("Error processing incoming message " + message + ". Reason: " + e);
            }
        }
        // need to affect original mail queue
        mail.clear();
        mail.addAll(tempMail);

        if (!mail.isEmpty()) {
            getLogger().fine("Pending messages: " + mail);
        }
    }

    @Override
    public void sendMsg(Message msg) throws Exception {
        processOutgoingMessage(msg);
        getLogger().fine("Sending message: " + msg);
        super.sendMsg(msg);
    }

    @Override
    public void broadcast(Message msg) throws Exception {
        processOutgoingMessage(msg);
        getLogger().fine("Broadcasting message: " + msg);
        super.broadcast(msg);
    }

    private Logger getLogger() {
        return getAgent().getLogger();
    }

    private JASDLAgent getAgent() {
        return (JASDLAgent) getTS().getAg();
    }

    private void processIncomingMessage(Message msg) throws JASDLException {
        Object propcont = msg.getPropCont();
        if (propcont == null) {
            return;
        }
        if (propcont instanceof Structure) { // only Structures require processing
            msg.setPropCont(processor.processIncomingStructure((Structure) propcont));
        }
    }

    private void processOutgoingMessage(Message msg) throws JASDLException {
        Object propcont = msg.getPropCont();
        if (propcont == null) {
            return;
        }
        if (propcont instanceof Structure) { // only Structures require processing
            msg.setPropCont(processor.processOutgoingStructure((Structure) propcont));
        }
    }

    /**
     * Applies incoming propositional content processing to incoming percepts from the environment.
     * This is performed so environments can create percepts for which alias and label mapping is properly performed.
     * This allows environments to reference ontological objects without knowing an agent's (arbitrary) mappings.
     */
    @Override
    public List<Literal> perceive() {
        List<Literal> unprocessedPercepts = super.perceive();
        if (unprocessedPercepts == null) {
            return null;
        }
        List<Literal> processedPercepts = new Vector<Literal>();
        for (Literal percept : unprocessedPercepts) {
            try {
                processedPercepts.add((Literal) processor.processIncomingStructure(percept));
            } catch (JASDLException e) {
                getLogger().warning("Error processing incoming percept " + percept + ". Reason: ");
                e.printStackTrace();
            }
        }
        return processedPercepts;
    }

}
