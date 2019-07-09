package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private BordersDAO dao;
	private Graph<Integer, DefaultEdge> grafo;
	private Map<Integer, Country> idMap;
	
	
	public Model() {
		this.dao = new BordersDAO();
		this.idMap = new HashMap<>();
		this.dao.loadAllCountries(idMap);
	}
	
	public void creaGrafo(Integer anno) {
		this.grafo = new SimpleGraph<>(DefaultEdge.class);
		List<Arco> list = this.dao.getArchi(anno);
		
		for(Arco a : list) {
			Graphs.addEdgeWithVertices(this.grafo, a.getV1(), a.getV2());
			System.out.println("Arco aggiunto: "+a.getV1()+ " -> "+ a.getV2());
		}
	}
	
	public int getVertici() {
		return this.grafo.vertexSet().size();
	}
	public int getArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<Stato> getStati(){
		List<Stato> result = new ArrayList<>();
		for(Integer i: this.grafo.vertexSet()) {
			Integer statiConfinanti = Graphs.neighborListOf(this.grafo, i).size();
			Stato stato = new Stato(idMap.get(i).getStateAbb(), idMap.get(i).getStateName(), statiConfinanti);
			result.add(stato);
		}
		return result;
	}

}
