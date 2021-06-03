{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "ambassador-jwt.name" -}}
{{- default .Chart.Name }}
{{- end }}

{{- define "ambassador-jwt.fullname" -}}
{{- $name := default .Chart.Name }}
{{- if contains $name .Release.Name }}
{{- .Release.Name | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" }}
{{- end }}
{{- end }}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "ambassador-jwt.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Common labels
*/}}
{{- define "ambassador-jwt.labels" -}}
helm.sh/chart: {{ include "ambassador-jwt.chart" . }}
{{ include "ambassador-jwt.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{/*
Selector labels
*/}}
{{- define "ambassador-jwt.selectorLabels" -}}
app.kubernetes.io/name: {{ include "ambassador-jwt.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}

