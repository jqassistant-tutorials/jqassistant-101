MATCH (element:Type:Java)
      -[:ANNOTATED_BY]->(annotation:Java:Annotation)
      -[:OF_TYPE]->(type:Java {fqn:'you.company.project.anno.Foo'}),
      (annotation)-[:HAS]->(attribute:Value {name:'name'})
RETURN attribute.value
