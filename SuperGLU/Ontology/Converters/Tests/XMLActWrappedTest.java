package Ontology.Converters.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Ontology.Converters.DataConverter;
import Ontology.Converters.XMLActWrapped;

public class XMLActWrappedTest
{

    @Test
    public void testConvert()
    {
	DataConverter converter = new XMLActWrapped("Speech");
	Object result = converter.convert("testString", null);
	
	result.toString();
	
	Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<act><participant id=\"Rachel\" role=\"actor\"/><fml><turn start=\"take\" end=\"give\"/><affect type=\"netural\" target=\"addressee\"/><culture type=\"neutral\"/><personality type=\"neutral\"/></fml><bml><speech id=\"sp1\" ref=\"DummyID\" type=\"application/ssml+xml\">testString</speech></bml></act>", result.toString());
    }

}