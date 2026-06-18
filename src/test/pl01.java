///*
// * Autor: André Luiz
// *
// *
// * Testando as estruturas, PILHA e FILA
// *
// */
//package test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.Test;
//
//import entidades.Atendimento;
//import entidades.Cliente;
//import entidades.TipoCliente;
//import estrutura.Fila;
//import estrutura.Pilha;
//
//class pl01 {
//
//	private Atendimento cria(int p_id) {
//		Cliente c = new Cliente(p_id, "TESTE", new Date(), TipoCliente.NORMAL);
//		return new Atendimento(c, new Date(), new Date(), 10);
//	}
//
//	@Test
//	void pilhaDeveRemoverUltimoInseridoPrimeiro() {
//		Pilha p = new Pilha();
//		Atendimento a1 = cria(1);
//		Atendimento a2 = cria(2);
//		Atendimento a3 = cria(3);
//
//		p.push(a1);
//		p.push(a2);
//		p.push(a3);
//
//		System.out.println(p);
//
//		assertSame(a3, p.pop());
//		assertSame(a2, p.pop());
//		assertSame(a1, p.pop());
//		assertNull(p.pop());
//		assertTrue(p.estaVazia());
//	}
//
//	@Test
//	void peekDaPilhaNaoDeveRemoverElemento() {
//		Pilha p = new Pilha();
//		Atendimento a1 = cria(1);
//
//		p.push(a1);
//
//		assertFalse(p.estaVazia());
//		assertSame(a1, p.peek());
//		assertSame(a1, p.peek());
//		assertSame(a1, p.pop());
//		assertTrue(p.estaVazia());
//	}
//
//	@Test
//	void pilhaVaziaDeveRetornarNull() {
//		Pilha p = new Pilha();
//
//		assertTrue(p.estaVazia());
//		assertNull(p.peek());
//		assertNull(p.pop());
//	}
//
//	@Test
//	void filaDeveRemoverPrimeiroInseridoPrimeiro() {
//		Fila f = new Fila();
//		Atendimento a1 = cria(1);
//		Atendimento a2 = cria(2);
//		Atendimento a3 = cria(3);
//
//		f.inserir(a1);
//		f.inserir(a2);
//		f.inserir(a3);
//
//		System.out.println(f);
//
//		assertSame(a1, f.remover());
//		assertSame(a2, f.remover());
//		assertSame(a3, f.remover());
//		assertNull(f.remover());
//		assertTrue(f.estaVazia());
//	}
//
//	@Test
//	void buscaPrimeiroDaFilaNaoDeveRemoverElemento() {
//		Fila f = new Fila();
//		Atendimento a1 = cria(1);
//		Atendimento a2 = cria(2);
//
//		f.inserir(a1);
//		f.inserir(a2);
//
//		assertFalse(f.estaVazia());
//		assertSame(a1, f.buscaPrimeiro());
//		assertSame(a1, f.buscaPrimeiro());
//		assertSame(a1, f.remover());
//		assertSame(a2, f.remover());
//	}
//
//	@Test
//	void filaVaziaDeveRetornarNull() {
//		Fila f = new Fila();
//
//		assertTrue(f.estaVazia());
//		assertNull(f.buscaPrimeiro());
//		assertNull(f.remover());
//	}
//
//}
