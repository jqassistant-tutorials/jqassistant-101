MATCH (element:Type:Java)
      -[:ANNOTATED_BY]->(annotation:Java:Annotation)
      -[:OF_TYPE]->(type:Java {fqn:'you.company.project.anno.Foo'})
RETURN element, annotation, type
