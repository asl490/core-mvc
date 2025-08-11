import os
import yaml
from jinja2 import Environment, FileSystemLoader

# Configuración de rutas
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
TEMPLATES_DIR = os.path.join(BASE_DIR, 'templates')
MODELS_DIR = os.path.join(BASE_DIR, 'models')
OUTPUT_BASE_DIR = os.path.join(BASE_DIR, '..', 'src', 'main', 'java') # Ruta relativa a la raíz del proyecto Java

# Configurar Jinja2
env = Environment(loader=FileSystemLoader(TEMPLATES_DIR))

def generate_file(template_path, output_path, context):
    """Genera un archivo a partir de una plantilla Jinja2."""
    template = env.get_template(template_path)
    output_content = template.render(context)

    os.makedirs(os.path.dirname(output_path), exist_ok=True)
    with open(output_path, 'w') as f:
        f.write(output_content)
    print(f"Generated: {output_path}")

def main():
    # Cargar el modelo de la entidad (ej. product.yaml)
    model_file = os.path.join(MODELS_DIR, 'product.yaml') # Puedes hacer esto dinámico
    with open(model_file, 'r') as f:
        entity_model = yaml.safe_load(f)

    entity_name = entity_model['entityName']
    entity_name_lower = entity_name.lower()
    package_base = entity_model['packageName']
    sub_package = entity_model['subPackageName']
    module_name = entity_model['moduleName']

    if sub_package:
        full_module_name = f"{sub_package}.{module_name}"
    else:
        full_module_name = module_name

    # Contexto común para todas las plantillas
    common_context = {
        'entity_name': entity_name,
        'entity_name_lower': entity_name_lower,
        'package_base': package_base,
        'module_name': full_module_name,
        'fields': entity_model['fields'],
        'id_type': entity_model['idType'],
        'entity_name_plural': entity_model.get('entityNamePlural', entity_name + 's') # Con valor por defecto
    }

    if sub_package:
        path_prefix = f"{sub_package}/{module_name}"
    else:
        path_prefix = module_name

    # Definir los archivos a generar y sus rutas relativas a templates/ y al paquete base
    # Esto es lo más importante y lo que tendrías que expandir
    files_to_generate = [

        ('service_impl.java.j2', f'{path_prefix}/service/impl/{entity_name}ServiceImpl.java'),
        ('service.java.j2', f'{path_prefix}/service/{entity_name}Service.java'),
        ('controller.java.j2', f'{path_prefix}/controller/{entity_name}Controller.java'),
        ('mapper.java.j2', f'{path_prefix}/util/{entity_name}Mapper.java'),
        ('entity.java.j2', f'{path_prefix}/entity/{entity_name}.java'),
        ('repository.java.j2', f'{path_prefix}/repository/{entity_name}Repository.java'),
        ('dto.java.j2', f'{path_prefix}/util/{entity_name}DTO.java'),

        # TODO: Add more templates for mappers, use cases, services, controllers, persistence
    ]

    for template_rel_path, output_rel_path_template in files_to_generate:
        # Renderizar la ruta de salida para incluir el nombre de la entidad
        output_rel_path = output_rel_path_template.replace('{{ entity_name }}', entity_name)
        output_rel_path = output_rel_path.replace('{{ entity_name_lower }}', entity_name_lower)

        # Construir la ruta completa de salida
        output_full_path = os.path.join(OUTPUT_BASE_DIR, package_base.replace('.', os.sep), output_rel_path.replace('/', os.sep))

        # Generar el archivo
        generate_file(template_rel_path, output_full_path, common_context)

if __name__ == "__main__":
    main()