package service;

import flex.messaging.FlexSession;
import flex.messaging.FlexSessionListener;
import flex.messaging.client.FlexClient;
import flex.messaging.client.FlexClientListener;
import flex.messaging.config.ConfigMap;
import flex.messaging.services.AbstractBootstrapService;

public class ControleUsuario extends AbstractBootstrapService implements FlexSessionListener, FlexClientListener{

	@Override
	public void initialize(String arg0, ConfigMap arg1) {
		// TODO Auto-generated method stub
		 ControleUsuario listener = new ControleUsuario();
	     FlexSession.addSessionCreatedListener(listener);
	     FlexClient.addClientCreatedListener(listener);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clientCreated(FlexClient client) {
		// TODO Auto-generated method stub
		client.addClientDestroyedListener(this);
		
	}

	@Override
	public void clientDestroyed(FlexClient arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionCreated(FlexSession session) {
		// TODO Auto-generated method stub
//		System.out.println("Sess�o criada: " + new Date().toString());
		session.addSessionDestroyedListener(this);
		
	}

	@Override
	public void sessionDestroyed(FlexSession arg0) {
		// TODO Auto-generated method stub
		
	}

}
