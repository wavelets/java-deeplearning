package org.deeplearning4j.apps;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.deeplearning4j.word2vec.Word2Vec;
import org.deeplearning4j.word2vec.sentenceiterator.FileSentenceIterator;


public class Word2VecTrainer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		FileSentenceIterator f = new FileSentenceIterator(new File(args[0]));
		Word2Vec vec = new Word2Vec(f);
		vec.setMinWordFrequency(1);
		vec.train();
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(args[1])));
		vec.write(bos);
		bos.flush();
		bos.close();
		
	}

}
